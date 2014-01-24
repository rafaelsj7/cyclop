package org.cyclop.service.completion.impl.parser.alterkeyspace;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.cyclop.model.CqlKeyword;
import org.cyclop.model.CqlNotSupported;
import org.cyclop.model.CqlQueryName;
import org.cyclop.service.completion.impl.parser.CqlPartCompletion;
import org.cyclop.service.completion.impl.parser.DecisionListSupport;

/**
 * @author Maciej Miklas
 */
@Named
class AlterKeyspaceDecisionListSupport implements DecisionListSupport {

    private final CqlKeyword supports = new CqlNotSupported("alter keyspace");

    private CqlPartCompletion[][] decisionList;

    @Inject
    AlterCompletion alterCompletion;

    @PostConstruct
    public void init() {
        decisionList = new CqlPartCompletion[][]{{alterCompletion}};
    }

    @Override
    public CqlPartCompletion[][] getDecisionList() {
        return decisionList;
    }

    @Override
    public CqlKeyword supports() {
        return supports;
    }

    @Override
    public CqlQueryName queryName() {
        return CqlQueryName.ALTER_KEYSPACE;
    }

}
