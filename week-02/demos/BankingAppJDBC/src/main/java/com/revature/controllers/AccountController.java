package com.revature.controllers;

import com.revature.dtos.response.ErrorMessage;
import com.revature.models.Role;
import com.revature.services.AccountService;
import io.javalin.http.Context;

public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // TODO Get all accounts / get user's accounts methods

    public void getAccountsHandler(Context ctx){
        // We will return a user's accounts if they are a customer
        // We will return all accounts if we are an admin

        if (ctx.sessionAttribute("userId") == null){
            ctx.status(401);
            ctx.json(new ErrorMessage("You must be logged in to view this endpoint"));
            return;
        }

        if (ctx.sessionAttribute("role") == Role.CUSTOMER){
            ctx.json(accountService.getUsersAccounts(ctx.sessionAttribute("userId")));
            ctx.status(200);
        } else {
            ctx.json(accountService.getAllAccounts());
            ctx.status(200);
        }
    }
}
