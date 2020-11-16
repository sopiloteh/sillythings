# Cars

The leading high-end sports car dealer in Beverly Hills is looking to improve customer satisfaction. To that end, they asked you to write software to track their sales metrics, which include wait times and agent performance, so they can decide on the agent mix. Here are their requirements.

When a customer arrives, she is assigned an agent with the highest expertise for the car she is planning to buy. If multiple agents match and are available, the one with the highest rating must be picked. And if no agent is available, the customer will wait and gets assigned to the next agent that becomes available.

Generally, each agent takes a different amount of time with the customer, but he takes the same time with every customer whether or not he closes the deal. For every deal closed, an agent is rewarded $10,000 in commission. If he closes 10 or more deals in a calendar week (i.e., Sunday through Saturday), he is further awarded a bonus of $100,000.

Your job is to create the logic to generate metrics for the customer wait times in minutes:

* Mean
* Median
* Standard deviation

In addition, you need to show the performance of the agents *in the ascending order of their IDs*:

* Deals closed
* Revenue generated for the dealer
* Commission
* Bonus

The dealer wants you to create unit tests to make sure that your software meets their requirements. In addition, they are providing you with test data for agents and customers for an integration test of the software - conduct the test with 5 agents and 100 customers.

Edit only the following files:

1. dealer/dealer.cpp
1. dealer/agent.cpp
1. test/dealer_test.cpp
1. test/agent_test.cpp
1. report.cpp

Run unit tests with **bazel test test:dealer_test** and **bazel test test:agent_test**. To generate the stats and report, run **bazel run report < data/rand.txt**.
