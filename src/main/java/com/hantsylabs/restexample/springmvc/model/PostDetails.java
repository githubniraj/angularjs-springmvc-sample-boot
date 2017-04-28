package com.hantsylabs.restexample.springmvc.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String title;

    private String content;
    
    private String status;

    private SimpleUserDetails createdBy;

    private LocalDateTime createdDate;

    private SimpleUserDetails lastModifiedBy;

    private LocalDateTime lastModifiedDate;

 }
