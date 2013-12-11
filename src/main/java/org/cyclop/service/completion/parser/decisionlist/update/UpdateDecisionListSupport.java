package org.cyclop.service.completion.parser.decisionlist.update;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.cyclop.service.completion.parser.decisionlist.CqlPartCompletion;
import org.cyclop.service.completion.parser.decisionlist.DecisionListSupport;
import org.cyclop.service.model.CqlKeyword;
import org.cyclop.service.model.CqlNotSupported;
import org.cyclop.service.model.CqlQueryType;

// TODO html help

/**
 * @author Maciej Miklas
 */
@Named
public class UpdateDecisionListSupport implements DecisionListSupport {

    private final CqlKeyword supports = new CqlNotSupported("update");

    private CqlPartCompletion[] decisionList;

    @Inject
    UpdatePartCompletion updatePartCompletion;

    @PostConstruct
    public void init() {
        decisionList = new CqlPartCompletion[]{updatePartCompletion};
    }

    @Override
    public CqlPartCompletion[] getDecisionList() {
        return decisionList;
    }

    @Override
    public CqlKeyword supports() {
        return supports;
    }

    @Override
    public CqlQueryType queryType() {
        return CqlQueryType.UPDATE;
    }

}
