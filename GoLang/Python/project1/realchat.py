#Thomas Dinh and Erick Bravo
#COMP 429 - Project 1: Chat Application
#3/10/2023

import socket
import threading
import sys
import os

HEADER = 1024
FORMAT = "utf-8"
connection_list = [] #list of connections
TERMINATE = "!TERMINATE"

#helper function to check whether an IP is valid or not
def is_valid_ip(ip):
    parts = ip.split('.')
    if not all(0 <= int(part) <= 255 for part in parts) or len(parts) != 4:
        return False

    return True

def is_duplicate(ip_addr, port_num):
    for dict in connection_list: #search through list
        if ip_addr == dict["ip_addr"] and port_num == dict["port_num"]:
            return True
    return False

#helper function to remove connection from list and readjust it
def remove_connection(connection):
    global connection_list
    index = 0
    for i, dict in enumerate(connection_list): #search through list
        if dict["socket"] == connection: #if value matches inside dictionary
            index = i #found index
    connection_list = connection_list[:index] + connection_list[index+1:] #adjust the list after removal

def close_all():
    for i, dict in enumerate(connection_list):
        send_message(i, TERMINATE, dict["socket"])

#create server
def init_server(host, port):
    try: #AF_INET for IPv4 and SOCK_STREAM for TCP
        server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        print("Socket successfully created.")
    except socket.error as err:
        print("Socket creation failed with error %s" %(err))


    while True:
        try:
            server.bind((host, port))
            print("Socket binded to %s" %port)
        except socket.error as err:
            print("Socket binding error" + str(err) + "\n" + "Retrying...")
        break

    server.listen()
    print(f"Socket is listening on ({host}, {port})")

    #accept all incoming connections
    while True:
        try:
            conn, addr = server.accept()
            print("Connection has been established:", addr)
        except socket.error as err:
            print(f"Error: Failure to accept connection: {err}")
            server.close()
            os._exit(1)
        #append dictionary of the information we need into the list
        connection_list.append({"ip_addr": addr[0], "port_num": addr[1], "socket": conn})
        #create thread for handle_client function, it also creates a new thread for each client
        #every time we accept someone
        thread = threading.Thread(target = receive_data, args = (conn, addr))
        thread.start()
        print("Got connection from", addr)
            




def receive_data(conn, addr):
    connected = True
    while connected:
        try:
            msg_length = conn.recv(HEADER).decode(FORMAT)
        except ConnectionResetError:
            print(f"Connection {addr[0]}:{addr[1]} disconnected\n")
            remove_connection(conn)
            connected = False
            return
        except ConnectionAbortedError:
            print(f"Connection {addr[0]}:{addr[1]} terminated unexpectedly\n")
            remove_connection(conn)
            connected = False
            return
        if not msg_length:
            connected = False
        if msg_length:
            msg_length = int(msg_length)
            #length of message should be only what we need it to be
            msg = conn.recv(msg_length).decode(FORMAT)
            if msg == TERMINATE:
                connected = False
                remove_connection(conn)
                print(f"Terminating connection to {(addr[0], addr[1])}")
                conn.shutdown(socket.SHUT_RDWR)
                conn.close()
                break
            
        if not connected:
            break
            
        print(f"Message received from {addr[0]}")
        print(f"Sender's Port: {addr[1]}")
        print(f'Message: "{msg}"\n')

    conn.close()


#this is just basically printing out the options
def user_interface(): 
    welcome_message = "Welcome to the chat application!\n" \
                  "---------------------------------------\n" \
                  "Command options:\n" \
                  "1. help\n" \
                  "2. myip\n" \
                  "3. myport\n" \
                  "4. connect\n" \
                  "5. list\n" \
                  "6. terminate\n" \
                  "7. send\n" \
                  "8. exit\n"
    print(welcome_message)

#print command manual function
def help():
    print("---------------------------------------\n" \
        "myip - display the IP address of this process\n" \
        "myport - display the port on which this address is listening for incoming connections\n" \
        "connect <destination> <port no> - connect to another peer\n" \
        "list - display a numbered list of all the connections this process if a part of\n" \
        "terminate <connection id> - terminates connection listed under the specified number\n" \
        "send <connection id> <message> - send the message to the host on the connection designated by id\n" \
        "exit - close all connections and terminate this process\n" \
        "---------------------------------------\n")

#function to connect to client
def client_connect(ip_addr, port_num):
    #set a local socket for client just in case
    try:
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        client.connect((ip_addr, port_num))
    except socket.error as err:
        print(f"Error connecting to socket: {err}")
        return
    print("Connection has been established with", (ip_addr, port_num))
    connection_list.append({"ip_addr": ip_addr, "port_num": port_num, "socket": client})
    thread = threading.Thread(target = receive_data, args = (client, (ip_addr, port_num)))
    thread.start()

#terminate function
def terminate(connection_id):
    try:
        rid_socket = connection_list[connection_id]["socket"]
        send_message(connection_id, TERMINATE, rid_socket)
        remove_connection(rid_socket)
        rid_socket.shutdown(socket.SHUT_RDWR)
        print(f"Terminated connection with ID: {connection_id}")
    except IndexError:
        print(f"Error: There is no connection with that ID!\n")

#send message function
def send_message(connection_id, message, recv_socket):
    msg = message.encode(FORMAT) #encode the message in utf-8 format
    msg_length = len(message) #get the length of the message
    #we use this length so that we don't just use a random number of bytes that would cause overhead
    send_length = str(msg_length).encode(FORMAT)
    #send an empty bytes string times the header minus the send_length
    send_length += b' ' * (HEADER - len(send_length))
    #we send all this padding based on the message format that is agreed upon by both sockets
    try:
        recv_socket.send(send_length) #send this for the handle_client
        recv_socket.send(msg)
        if message != TERMINATE:
            print(f"Message sent to {connection_id}\n")
    except socket.error:
        print("Error: Failed to send message\n")
    #received_data = recv_socket.recv(2048).decode(FORMAT)
    #message = message = received_data[HEADER:] #slice the message payload from the received data
    #print(message)

def command_options(host, port):
    global connection_list
    user_interface()
    while True:
        cmd = input()
        if cmd == "help":
            help()
        elif cmd == "myip":
            print(host)
        elif cmd == "myport":
            print(port)
        elif "connect" in cmd:
            args = cmd.split() #checks for spaces
            if len(args) != 3:
                print("Error: Invalid command format. Use 'connect <destination ip> <port>'\n")
                continue
            connect_ip = args[1]
            if not is_valid_ip(connect_ip):
                print("Error: Invalid IP address\n")
                continue
            try:
                connect_port = int(args[2]) #must convert port into int
            except ValueError:
                print("Error: Port must be an integer\n")
                continue
            except Exception as e:
                print(f"Error: Couldn't connect due to {e}\n")
                continue
            if connect_ip == host and connect_port == port:
                print("Error: Cannot self-connect\n")
                continue
            if is_duplicate(connect_ip, connect_port):
                print("Error: Duplicate IP and port\n")
                continue
            client_connect(connect_ip, connect_port)
        elif cmd == "list": 
            info = "id:\tIP address\tPort No.\n"
            for id, dict in enumerate(connection_list): 
                info += f"{id}:\t{dict['ip_addr']}\t{dict['port_num']}\n"
            print(info)
        elif "terminate" in cmd:
            args = cmd.split()
            if len(args) != 2:
                print("Error: Invalid command format. Use 'terminate <connection id>'\n")
                continue
            try:
                connection_id = int(args[1]) #must be an integer!
                if connection_id < 0:
                    raise ValueError
            except ValueError:
                print("Error: ID must be a positive integer!\n")
                continue
            else:
                terminate(connection_id)
        elif "send" in cmd:
            args = cmd.split()
            if len(args) < 3:
                print("Error: Invalid command format. Use 'send <connection id> <message>'\n")
                continue
            try:
                connection_id = int(args[1])
                if connection_id < 0:
                    raise ValueError
            except ValueError:
                print("Error: ID must be a positive integer!\n")
                continue
            message = " ".join(args[2:])
            if len(message) > 100:
               print("Error: Length of message can only be up to 100 characters!\n")
               continue
            try:
                send_message(connection_id, message, connection_list[connection_id]["socket"])
            except IndexError:
                print(f"Error: Valid connection does not exist with this ID: {connection_id}\n")
                continue
        elif cmd == "exit":
            close_all()
            del connection_list
            print("Exiting...")
            break
        else:
            print(cmd)



if __name__ == "__main__":

    if len(sys.argv) != 2:
        print("Error: Invalid command format. Use 'connect <destination ip> <port>'\n")
        sys.exit(1)

    host = socket.gethostbyname(socket.gethostname())
    port = int(sys.argv[1]) #get port through command line argument

    server_thread = threading.Thread(target=init_server, args = (host, port), daemon=True) #create a thread to accept incoming connections
    server_thread.start()
    command_options(host, port) #that way we can use another thread to take in input command
    sys.exit(0)
