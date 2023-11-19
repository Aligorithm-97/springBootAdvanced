package com.example.springadvanced.log;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogDao extends JpaRepository<LogObject,Long> {
}