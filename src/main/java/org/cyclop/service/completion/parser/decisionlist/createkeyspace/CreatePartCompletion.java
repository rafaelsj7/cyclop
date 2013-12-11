package org.cyclop.service.completion.parser.decisionlist.createkeyspace;

import javax.inject.Named;
import org.cyclop.service.completion.parser.decisionlist.NotSupportedCompletion;
import org.cyclop.service.model.CqlNotSupported;
import org.cyclop.service.model.CqlPart;

/**
 * @author Maciej Miklas
 */
@Named("createkeyspace.CreatePartCompletion")
public class CreatePartCompletion extends NotSupportedCompletion {

    private final CqlPart[] startMarker = new CqlPart[]{new CqlNotSupported("create")};

    @Override
    public CqlPart[] startMarkers() {
        return startMarker;
    }

    @Override
    protected String getNotSupportedText() {
        return "create keyspace";
    }
}
