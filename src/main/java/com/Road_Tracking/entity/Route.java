package com.Road_Tracking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("route")  // Map to your DB table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {

    @Id  // This marks the primary key
    private Long id;

    private String source;
    private String destination;
    private double distance; // in km

}
