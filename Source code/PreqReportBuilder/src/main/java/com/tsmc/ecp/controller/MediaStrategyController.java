package com.tsmc.ecp.controller;

import com.tsmc.ecp.strategy.FacebookStrategy;
import com.tsmc.ecp.strategy.GooglePlusStrategy;
import com.tsmc.ecp.strategy.SocialMediaContext;
import com.tsmc.ecp.strategy.TwitterStrategy;

//https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/
public class MediaStrategyController {

    public static void main(String[] args) {

        // Creating social Media Connect Object for connecting with friend by
        // any social media strategy.
        SocialMediaContext context = new SocialMediaContext();

        // Setting Facebook strategy.
        context.setSocialmediaStrategy(new FacebookStrategy());
        context.connect("Lokesh");

        System.out.println("====================");

        // Setting Twitter strategy.
        context.setSocialmediaStrategy(new TwitterStrategy());
        context.connect("Lokesh");

        System.out.println("====================");

        // Setting GooglePlus strategy.
        context.setSocialmediaStrategy(new GooglePlusStrategy());
        context.connect("Lokesh");

    }
}
