package gUnit;

import annotations.After;
import annotations.Before;
import annotations.Test;
import gUnit.model.User;

public class GUnitUserTest {
    private User defaultUser;

    @Before
    public void initFirst(){
        System.out.println("First init");
        defaultUser = new User("Default", 99);
    }

    @Before
    public void initSecond(){
        System.out.println("Second init");
    }

    @Test
    public void userTest(){
        System.out.println(defaultUser.toString());
    }
    @After
    public void firstAfter(){
        System.out.println("First after");
    }

}
