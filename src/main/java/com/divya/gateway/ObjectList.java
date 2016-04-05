package com.divya.gateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by divyashreenair on 28/3/16.
 */
public class ObjectList {
    HashMap<String, List<Test>> Clients;

    public HashMap<String, List<Test>> getClients() {
        return Clients;
    }

    public void setClients(HashMap<String, List<Test>> clients) {
        Clients = clients;
    }
}
