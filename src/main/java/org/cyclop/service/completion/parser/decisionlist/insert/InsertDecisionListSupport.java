package org.cyclop.service.completion.parser.decisionlist.insert;

import org.cyclop.model.CqlKeyword;
import org.cyclop.model.CqlQueryType;
import org.cyclop.service.completion.parser.decisionlist.CqlPartCompletion;
import org.cyclop.service.completion.parser.decisionlist.DecisionListSupport;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Maciej Miklas
 */
@Named
public class InsertDecisionListSupport implements DecisionListSupport {

    private final CqlKeyword supports = new CqlKeyword("insert into");

    @Inject
    private TableNameCompletion tableNameCompletion;

    @Inject
    private ColumnsCompletion columnsCompletion;

    @Inject
    private AfterColumnsCompletion afterColumnsCompletion;

    @Inject
    private AfterValuesPartCompletion afterValuesPartCompletion;

    private CqlPartCompletion[] decisionList;

    @PostConstruct
    public void init() {
        decisionList = new CqlPartCompletion[]{tableNameCompletion, columnsCompletion,
                afterColumnsCompletion, afterValuesPartCompletion};
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
        return CqlQueryType.INSERT;
    }

}
