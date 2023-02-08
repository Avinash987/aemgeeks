package com.aem.geeks.core.models.impl;

import com.aem.geeks.core.models.MyModel;
import com.day.cq.wcm.api.Page;
import org.apache.lucene.search.suggest.analyzing.FreeTextSuggester;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = MyModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyModelImpl implements MyModel {
    private static final Logger LOG = LoggerFactory.getLogger(MyModelImpl.class);

    @Inject
    Resource componentResource;

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ScriptVariable
    Page currentPage;

    @Inject
    @Via("resource")
    private String firstName;

    @ValueMapValue
    private String lastName;

    @Inject
    @Via("resource")
    private boolean professor;

    @ValueMapValue
    private List<String> books;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public List<String> getAuthorBooks(){
        if(books != null){
            return books;
        }
        else {
            return Collections.emptyList();
        }
    }

    @Override
    public String getPageTitle(){
        return currentPage.getTitle();
    }

    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    public SlingHttpServletRequest getSlingHttpServletRequest() {
        return slingHttpServletRequest;
    }

    public String getReqAttribute() {
        return reqAttribute;
    }
}
