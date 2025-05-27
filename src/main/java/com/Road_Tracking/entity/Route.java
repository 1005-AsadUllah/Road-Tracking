package com.Road_Tracking.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("route")  // Map to your DB table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {

    @Id  // This marks the primary key
    private Long id;

    @Setter
    private String source;

    @Setter
    private String destination;

    @Setter
    private double distance; // in km

}
