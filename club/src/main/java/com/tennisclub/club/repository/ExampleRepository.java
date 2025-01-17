package com.tennisclub.club.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository {
    public String fetchData() {
        return "Data from Repository";
    }
}