package com.entity;

import lombok.Data;

@Data
public class PlanProjetEntity {
    private int id;
    private String centreProject;
    private String provincialProject;
    private String cityProject;
    private String localProject;
    private String otherProject;

}
