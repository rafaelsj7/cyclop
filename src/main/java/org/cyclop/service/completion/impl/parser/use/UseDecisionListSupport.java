package org.cyclop.service.completion.impl.parser.use;

import org.cyclop.model.CqlKeyword;
import org.cyclop.model.CqlQueryType;
import org.cyclop.service.completion.impl.parser.CqlPartCompletion;
import org.cyclop.service.completion.impl.parser.DecisionListSupport;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/** @author Maciej Miklas */
@Named
class UseDecisionListSupport implements DecisionListSupport {

	private final CqlKeyword supports = CqlKeyword.Def.USE.value;

	private CqlPartCompletion[][] decisionList;

	@Inject
	UseCompletion useCompletion;

	@PostConstruct
	public void init() {
		decisionList = new CqlPartCompletion[][]{{useCompletion}};
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
	public CqlQueryType queryName() {
		return CqlQueryType.USE;
	}

}
