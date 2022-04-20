package com.example.schoolbooks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private String bookName;
    private Integer classNum;
    private String lang;
    private String info;
    private String photo;
    private boolean save;
}
