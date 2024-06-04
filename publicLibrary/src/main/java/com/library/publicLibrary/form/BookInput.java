package com.library.publicLibrary.form;

import lombok.Data;

@Data
public class BookInput {

    private String title;
    private String author;
    private String genre;
    private boolean available;
}
