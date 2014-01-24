package org.cyclop.service.completion.impl;

import javax.annotation.concurrent.ThreadSafe;
import org.cyclop.model.ContextCqlCompletion;
import org.cyclop.model.CqlCompletion;
import org.cyclop.model.CqlQuery;
import org.cyclop.model.CqlQueryName;
import org.cyclop.service.completion.CqlCompletionService;
import org.cyclop.service.completion.impl.parser.CqlParser;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Maciej Miklas
 */
@Named
@ThreadSafe
class CqlCompletionServiceImpl implements CqlCompletionService {

    @Inject
    private CqlParser parser;

    @Override
    public ContextCqlCompletion findInitialCompletion() {
        return new ContextCqlCompletion(CqlQueryName.UNKNOWN, parser.findInitialCompletion());
    }

    @Override
    public ContextCqlCompletion findCompletion(CqlQuery cqlQuery, int cursorPosition) {
        ContextCqlCompletion comp = parser.findCompletion(cqlQuery, cursorPosition);
        if (comp == null) {
            comp = new ContextCqlCompletion(CqlQueryName.UNKNOWN, CqlCompletion.Builder.naturalOrder().build());
        }

        return comp;
    }
}
