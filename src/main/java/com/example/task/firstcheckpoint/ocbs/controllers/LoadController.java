package com.example.task.firstcheckpoint.ocbs.controllers;

import com.example.task.firstcheckpoint.ocbs.dtos.Load;
import com.example.task.firstcheckpoint.ocbs.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "load")
public class LoadController {

  private final LoadService loadService;

  @Autowired
  public LoadController(LoadService loadService) {
    this.loadService = loadService;
  }

  @GetMapping
  public List<Load> getLoads() {
    return loadService.getLoads();
  }

  @PutMapping(path = "bookLoad")
  public void bookLoad(@RequestBody Load load) {
    loadService.bookLoad(load);
  }
}
