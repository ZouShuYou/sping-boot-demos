package com.springboot.demos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-22 9:48
 */

@Data
@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Category implements Serializable {

    private static final long serialVersionUID = -8082630709702750991L;
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "rank")
    private String rank;
}
