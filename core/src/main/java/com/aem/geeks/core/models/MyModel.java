package com.aem.geeks.core.models;

import java.util.List;

public interface MyModel {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
    String getPageTitle();

    List<String> getAuthorBooks();
}
