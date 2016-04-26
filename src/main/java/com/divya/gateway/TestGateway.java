package com.divya.gateway;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.juli.logging.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by divyashreenair on 23/3/16.
 */
@RestController
public class TestGateway {
    Test testObj;
    ObjectList obj = new ObjectList();
//    GetList getList;
    HashMap<String, List<Test>> map;
    ObjectList obj1;
    @RequestMapping("/clients1")
    public ResponseEntity<ObjectList> get(){
        GetTest getTest = new GetTest();
        getTest.setTask("hello");
        getTest.setTestString("lkioooo");
        getTest.setTitle("eeee");

        GetTest getTest1 = new GetTest();
        getTest1.setTask("hello");
        getTest1.setTestString("lkioooo");
        getTest1.setTitle("eeee");

//        GetList get = new GetList();
//        get.list1.add(getTest);
//        get.list1.add(getTest);
//        get.list1.add(getTest);
//        get.list1.add(getTest);
//
//        GetList get1 = new GetList();
//        get.list2.add(getTest1);
//        get.list2.add(getTest1);
//        get.list2.add(getTest1);
//        get.list2.add(getTest1);

        //obj.setName(get);
        //obj.setName(get1);

        return new ResponseEntity<ObjectList>(obj,HttpStatus.OK);
    }

    @RequestMapping("/hello")
    public String test(){
        return "Helloooo";
    }

    @RequestMapping("/test")
    public ResponseEntity<Test> getFunction(){
        Test test = new Test();
        test.getTestString();
        test.getTitle();
        test.getTask();
        return new ResponseEntity<Test>(test, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<Test> createUser(@RequestBody String jsonString) throws IOException {
        System.out.println("Json String " + jsonString);
        //testObj = convertJsonStringToObject(jsonString, Test.class);
        testObj.setTestString(testObj.getTestString());
        testObj.setTask(testObj.getTask());
        testObj.setTitle(testObj.getTitle());
        System.out.println(testObj.getTask() + ".." + testObj.getTestString() + ".. " + testObj.getTitle());
        return new ResponseEntity<Test>(testObj, HttpStatus.OK);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<ObjectList> getUser(){
        testObj.getTask();
        testObj.getTestString();
        testObj.getTitle();
        GetList get = new GetList();

//        get.list2.add(testObj);
//        get.list2.add(testObj);
//        get.list2.add(testObj);
//        get.list2.add(testObj);

        ObjectList obj1 = new ObjectList();
        //obj1.setName(get);

        System.out.println("Inside get function");
        return new ResponseEntity<ObjectList>(obj1, HttpStatus.OK);
    }
    @RequestMapping(value = "/userString", method = RequestMethod.GET)
    public ResponseEntity<ObjectList> getClients(){
        testObj.getTask();
        testObj.getTestString();
        testObj.getTitle();
        return new ResponseEntity<ObjectList>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/user123", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<ObjectList> createUser1(@RequestBody String jsonString) throws IOException {
        System.out.println("Json String " + jsonString);
        obj1 = new ObjectList();
        convertJsonStringToObject1(jsonString);
        obj1.setClients(map);

        return new ResponseEntity<ObjectList>(obj1, HttpStatus.OK);
    }
    @RequestMapping(value = "/user123", method = RequestMethod.GET)
    public ResponseEntity<ObjectList> getClients1(){
        obj1.getClients();
        return new ResponseEntity<ObjectList>(obj1, HttpStatus.OK);
    }

//    public <T>T convertJsonStringToObject(String jsonString, Class<?> returningClass) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            //Object o = mapper.readValue(jsonString, returningClass);
//            ArrayList<Test> myObjects = mapper.readValue(jsonString, new TypeReference<List<Test>>(){});
//            //getList.setList2(myObjects);
//            System.out.println("testing" + myObjects.get(0).toString());
//            if (myObjects == null) {
//                throw new NullPointerException("Json conversion failed");
//            }
//            return  (T) myObjects;
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//        }
//    }
    public void convertJsonStringToObject1(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = new HashMap<String, List<Test>>();
            map = mapper.readValue(jsonString, new TypeReference<HashMap<String, List<Test>>>(){});
            if (map == null) {
                throw new NullPointerException("Json conversion failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
