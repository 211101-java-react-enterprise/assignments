package com.revature.banking.screens;
import com.revature.banking.util.ScreenRouter;
import com.revature.banking.services.UserService;

import java.io.BufferedReader;

public class DepositScreen extends Screen{
    private final UserService userService;

    public DepositScreen(BufferedReader consolReader, ScreenRouter router, UserService userService){
        super("deposit", "/deposit", consolReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("How much would you like to deposit?");
        String response = consoleReader.readLine();
        //TODO: call class that tracks the users money
    }
}
