package org.cyclop.service.completion.parser.decisionlist.truncate;

import javax.inject.Named;
import org.cyclop.service.completion.parser.decisionlist.NotSupportedCompletion;
import org.cyclop.service.model.CqlPart;

/**
 * @author Maciej Miklas
 */
@Named("truncate.TruncatePartCompletion")
public class TruncatePartCompletion extends NotSupportedCompletion {

    private final CqlPart[] startMarker = new CqlPart[]{new CqlPart("truncate")};

    @Override
    public CqlPart[] startMarkers() {
        return startMarker;
    }

    @Override
    protected String getNotSupportedText() {
        return "truncate";
    }
}
