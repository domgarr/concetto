package com.domgarr.concetto.api.v1.model;

import com.domgarr.concetto.models.InterInterval;
import com.domgarr.concetto.models.Subject;
import lombok.Data;

import java.util.Date;

//TODO: Rewrite this explanation.
/*
    DTO in this case seems like overkill, but it's a good practice to use incase in the future there is a use-case.
    For example, if i wanted create a response that combined a call from another API and the call from my database - only
    the DTO would need to be altered. That's the way it should be, the Model should only contain data to be saved and retreived
    from the database.
 */

@Data
public class ConceptDTO {
    private Long id;
    private InterInterval interInterval;
    private Subject subject;
    private String name;
    private String explanation;
    private boolean reviewed;
    private boolean simplified;
    private Date dateCreated;
    private Date dateLastReviewed;
}
