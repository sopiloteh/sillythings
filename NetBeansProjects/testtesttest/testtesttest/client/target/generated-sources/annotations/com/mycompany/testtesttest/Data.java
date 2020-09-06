package com.mycompany.testtesttest;
import net.java.html.json.*;
/** Generated for {@link DataModel}*/
public final class Data implements Cloneable {
  private static Class<DataModel> modelFor() { return DataModel.class; }
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final DataModel instance = new DataModel();
  private final org.netbeans.html.json.spi.Proto proto;
  private java.lang.String prop_active;
  public java.lang.String getActive() {
    proto.accessProperty("active");
    return (java.lang.String)prop_active;
  }
  public void setActive(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_active;
    if (TYPE.isSame(o , v)) return;
    prop_active = v;
    proto.valueHasMutated("active", o, v);
  }
  /** @see DataModel#drawCanvas */
  public void drawCanvas() {
    proto.runInBrowser(4);
  }
  /** @see DataModel#lineChart */
  public void lineChart() {
    proto.runInBrowser(5);
  }
  /** @see DataModel#pieChart */
  public void pieChart() {
    proto.runInBrowser(6);
  }
  /** @see DataModel#map */
  public void map() {
    proto.runInBrowser(7);
  }
  private Data(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
  };
  public Data() {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
  };
  public Data(java.lang.String aActive) {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
    this.prop_active = aActive;
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Data> {
    private Html4JavaType() {
      super(Data.class, DataModel.class, 1, 4);
      registerProperty("active", 0, false, false);
      registerFunction("drawCanvas", 0);
      registerFunction("lineChart", 1);
      registerFunction("pieChart", 2);
      registerFunction("map", 3);
    }
    @Override public void setValue(Data data, int type, Object value) {
      switch (type) {
        case 0: data.setActive(TYPE.extractValue(java.lang.String.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Data data, int type) {
      switch (type) {
        case 0: return data.getActive();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Data model, int type, Object data, Object ev) throws Exception {
      switch (type) {
        case 0:
          model.instance.drawCanvas(model);
          return;
        case 1:
          model.instance.lineChart(model);
          return;
        case 2:
          model.instance.pieChart(model);
          return;
        case 3:
          model.instance.map(model);
          return;
        case 4:
          { Object[] arr = (Object[])data; model.instance.drawCanvas(model); }
          return;
        case 5:
          { Object[] arr = (Object[])data; model.instance.lineChart(model); }
          return;
        case 6:
          { Object[] arr = (Object[])data; model.instance.pieChart(model); }
          return;
        case 7:
          { Object[] arr = (Object[])data; model.instance.map(model); }
          return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Data)obj).proto;    }
    @Override public void onChange(Data model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Data model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Data read(net.java.html.BrwsrCtx c, Object json) { return new Data(c, json); }
    @Override public Data cloneTo(Data o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Data(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[1];
    proto.extract(json, new String[] {
      "active",
    }, ret);
    this.prop_active = (java.lang.String)ret[0];
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("active").append('"').append(":");
    sb.append(TYPE.toJSON(getActive()));
    sb.append('}');
    return sb.toString();
  }
  public Data clone() {
    return clone(proto.getContext());
  }
  private Data clone(net.java.html.BrwsrCtx ctx) {
    Data ret = new Data(ctx);
    ret.prop_active = getActive();
    return ret;
  }
  /** Activates this model instance in the current {@link 
net.java.html.json.Models#bind(java.lang.Object, net.java.html.BrwsrCtx) browser context}. 
In case of using Knockout technology, this means to 
bind JSON like data in this model instance with Knockout tags in 
the surrounding HTML page.
This method binds to element '""' on the page
@return <code>this</code> object
*/
  public Data applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Data)) return false;
    Data p = (Data)o;
    if (!TYPE.isSame(prop_active, p.prop_active)) return false;
    return true;
  }
  public int hashCode() {
    int h = Data.class.getName().hashCode();
    h = TYPE.hashPlus(prop_active, h);
    return h;
  }
}
