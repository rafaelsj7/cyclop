package org.cyclop.service.completion.parser.decisionlist.update;

import com.google.common.collect.ImmutableSortedSet;
import org.cyclop.common.QueryHelper;
import org.cyclop.model.*;
import org.cyclop.service.cassandra.QueryService;
import org.cyclop.service.completion.parser.decisionlist.CqlPartCompletionDynamic;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import static org.cyclop.model.CqlKeywords.UPDATE;

/**
 * @author Maciej Miklas
 */
@Named("update.AfterUpdateClauseCompletion")
public class AfterUpdateCCompletion implements CqlPartCompletionDynamic {

    private CqlCompletion completion;

    @Inject
    private QueryService queryService;

    @PostConstruct
    public void init() {
        ImmutableSortedSet.Builder<CqlPart> completionBuild = ImmutableSortedSet.naturalOrder();
        completionBuild.add(new CqlKeyword("using ttl"));
        completionBuild.add(new CqlKeyword("using timestamp"));
        completionBuild.add(new CqlKeyword("set"));
        ImmutableSortedSet<CqlPart> staticPart = completionBuild.build();
        completion = new CqlCompletion(staticPart, staticPart);
    }

    @Override
    public CqlCompletion getCompletion(CqlQuery query) {
        return completion;
    }

    @Override
    public int canApply(CqlQuery query, int queryPosition) {

        CqlTable table = QueryHelper.extractTableName(UPDATE, query);
        if (table == null) {
            return -1;
        }

        int index = -1;
        if (queryService.checkTableExists(table)) {
            index = query.cqlLc.indexOf(table.partLc) + table.partLc.length();
        }
        return index;
    }
}
