package org.cyclop.service.completion.parser.decisionlist.dropkeyspace;

import javax.inject.Named;
import org.cyclop.service.completion.parser.decisionlist.NotSupportedCompletion;
import org.cyclop.service.model.CqlKeyword;
import org.cyclop.service.model.CqlPart;

/**
 * @author Maciej Miklas
 */
@Named("dropkeyspace.DropPartCompletion")
public class DropPartCompletion extends NotSupportedCompletion {

    private final CqlPart[] startMarker = new CqlPart[]{new CqlKeyword("drop")};

    @Override
    public CqlPart[] startMarkers() {
        return startMarker;
    }

    @Override
    protected String getNotSupportedText() {
        return "drop keyspace";
    }
}
