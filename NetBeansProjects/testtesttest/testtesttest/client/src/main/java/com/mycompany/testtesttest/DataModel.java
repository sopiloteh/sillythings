package com.mycompany.testtesttest;

import com.dukescript.api.canvas.GraphicsContext2D;
import com.dukescript.api.events.EventHandler;
import com.dukescript.api.events.EventSource;
import com.dukescript.api.events.MouseEvent;
import com.dukescript.api.events.TouchEvent;
import com.mycompany.testtesttest.js.Elements;
import net.java.html.charts.Chart;
import net.java.html.charts.Color;
import net.java.html.charts.Config;
import net.java.html.charts.Segment;
import net.java.html.charts.Values;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;
import net.java.html.leaflet.LatLng;
import net.java.html.leaflet.Map;
import net.java.html.leaflet.MapOptions;
import net.java.html.leaflet.Polygon;
import net.java.html.leaflet.Popup;
import net.java.html.leaflet.PopupOptions;
import net.java.html.leaflet.TileLayer;
import net.java.html.leaflet.TileLayerOptions;
import net.java.html.leaflet.event.MouseEvent.Type;

/** The "UI" of the page. Observes clicks on the top margin buttons and
 * switches the views according to active one.
 */
@Model(className = "Data", targetId="", instance = true, properties = {
    @Property(name = "active", type = String.class)
})
final class DataModel {
    EventSource<GraphicsContext2D> es;
    EventSource<GraphicsContext2D> esTouch;
    private Chart<Values, Config> lineChart;
    private Chart<Segment, Config> pieChart;
    private Map map;

    @Function @ModelOperation
    void drawCanvas(Data model) {
        model.setActive("canvas");

        GraphicsContext2D ctx = GraphicsContext2D.getOrCreate("canvas");
        ctx.clearRect(0, 0, ctx.getWidth(), ctx.getHeight());
        ctx.setFillStyle(ctx.getWebColor("blue"));
        ctx.setStrokeStyle(ctx.getWebColor("#00007f"));
        ctx.setLineJoin("round");
        ctx.setLineWidth(5);
        int width = ctx.getWidth();
        int height = ctx.getHeight();
        for (int i = 30; i < width - 30; i += 50) {
            ctx.beginPath();
            ctx.moveTo(i, 0);
            final int end = height * i / width;
            ctx.lineTo(i, end);
            ctx.stroke();
            ctx.fillRect(i - 10, end, 20, 20);
        }

        ctx.setFont("30px Monospaced");
        ctx.setFillStyle(ctx.getWebColor("black"));
        int[] size = Elements.screenSize();
        ctx.fillText("Hello from DukeScript!" + size[0] + " x " + size[1], 10, height - 30);

        es = EventSource.create(ctx, "canvas", true);

        es.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GraphicsContext2D g2d = (GraphicsContext2D) event.getSource();
                g2d.setFillStyle(g2d.getWebColor("orange"));
                g2d.fillCircle((float) event.getX(), (float) event.getY(), 10);
            }
        });
        esTouch = EventSource.create(ctx, "canvas", true);
        esTouch.addEventHandler(TouchEvent.ANY, new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                GraphicsContext2D g2d = (GraphicsContext2D) event.getSource();
                g2d.setFillStyle(g2d.getWebColor("orange"));
                g2d.fillCircle((float) event.getPrimaryTouch().getX(), (float) event.getPrimaryTouch().getY(), 10);
            }
        });
    }


    @Function @ModelOperation
    void lineChart(Data model) {
        model.setActive("lineChart");

        if (lineChart == null) {
            lineChart = Chart.createLine(
                new Values.Set("1st", Color.valueOf("gray"), Color.valueOf("black")),
                new Values.Set("2nd", Color.valueOf("lightgray"), Color.valueOf("yellow"))
            );
            lineChart.applyTo("lineChart");
        }

        lineChart.getData().add(new Values("#1", 3.0, 5.0));
        lineChart.getData().add(new Values("#2", 4.0, 6.0));
        lineChart.getData().add(new Values("#3", 6.0, 2.0));
        lineChart.getData().add(new Values("#4", 3.0, 1.0));
    }

    @Function @ModelOperation
    void pieChart(Data model) {
        model.setActive("pieChart");

        if (pieChart == null) {
            pieChart = Chart.createPie();
            pieChart.applyTo("pieChart");
        }

        final Color hoverColor = Color.valueOf("gray");
        pieChart.getData().add(new Segment("#1", 3.0, Color.valueOf("red"), hoverColor));
        pieChart.getData().add(new Segment("#2", 2.0, Color.valueOf("blue"), hoverColor));
        pieChart.getData().add(new Segment("#3", 1.0, Color.valueOf("green"), hoverColor));
        pieChart.getData().add(new Segment("#5", 4.0, Color.valueOf("yellow"), hoverColor));
    }

    @Function @ModelOperation
    void map(Data model) {
        model.setActive("map");

        final LatLng center = new LatLng(48.1322836,11.536);
        if (map != null) {
            map.setView(center);
            map.clearAllEventListeners();
        } else {
            MapOptions mapOptions = new MapOptions()
                    .setCenter(center)
                    .setZoom(17);
            map = new Map("map", mapOptions);

            // add a tile layer to the map
            TileLayerOptions tlo = new TileLayerOptions();
            tlo.setAttribution("Map data &copy; <a href='https://www.thunderforest.com/opencyclemap/'>OpenCycleMap</a> contributors, "
                    + "<a href='https://creativecommons.org/licenses/by-sa/2.0/'>CC-BY-SA</a>, "
                    + "Imagery © <a href='https://www.thunderforest.com/'>Thunderforest</a>");
            tlo.setMaxZoom(18);
            TileLayer layer = new TileLayer("https://{s}.tile.thunderforest.com/cycle/{z}/{x}/{y}.png", tlo);
            map.addLayer(layer);
        }

        Polygon polygonLayer = new Polygon(new LatLng[] {
            new LatLng(48.13159, 11.53622),
            new LatLng(48.1325, 11.5370),
            new LatLng(48.1335, 11.5370),
            new LatLng(48.1321, 11.5350),
        });
        polygonLayer.addMouseListener(Type.CLICK, (ev) -> {
            PopupOptions popupOptions = new PopupOptions().setMaxWidth(400);
            Popup popup = new Popup(popupOptions);
            popup.setLatLng(ev.getLatLng());
            popup.setContent("DukeScript brand got invented here!");
            popup.openOn(map);
        });
        map.addLayer(polygonLayer);

        map.addMouseListener(Type.CLICK, (ev) -> {
            final LatLng at = ev.getLatLng();
            PopupOptions popupOptions = new PopupOptions().setMaxWidth(400);
            Popup popup = new Popup(popupOptions);
            popup.setLatLng(at);
            popup.setContent("@" + at.getLatitude() + "," + at.getLongitude());
            popup.openOn(map);
        });
    }

    /**
     * Called when the page is ready.
     */
    static void onPageLoad() {
        Data ui = new Data();
        ui.applyBindings();
    }
}
