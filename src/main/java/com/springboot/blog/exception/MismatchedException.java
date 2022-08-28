package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MismatchedException extends RuntimeException {

    private String childEntityName;
    private String parentEntityName;

    public MismatchedException(String childEntityName, String parentEntityName){
        super(String.format("%s does not belong to %s", childEntityName, parentEntityName));
        this.childEntityName = childEntityName;
        this.parentEntityName = parentEntityName;
    }

    public String getChildEntityName() {
        return childEntityName;
    }

    public String getParentEntityName() {
        return parentEntityName;
    }
}
