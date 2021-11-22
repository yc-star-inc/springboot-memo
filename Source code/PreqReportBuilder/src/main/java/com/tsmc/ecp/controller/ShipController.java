package com.tsmc.ecp.controller;

import com.tsmc.ecp.state.DeliveryContext;

public class ShipController {

    public static void main(String[] args) {

        DeliveryContext ctx = new DeliveryContext(null, "Test123");

        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
    }
}
