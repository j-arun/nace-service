package com.example.nace.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Nace")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Nace{
    @Id
    private long  Order_Number ;
    private String Code;
    private String Level;
    private String Parent;
    private String Description;
    private String This_item_includes;
    private String This_item_also_includes;
    private String Rulings;
    private String This_item_excludes;
    private String Reference_to_ISIC_Rev4;
}






