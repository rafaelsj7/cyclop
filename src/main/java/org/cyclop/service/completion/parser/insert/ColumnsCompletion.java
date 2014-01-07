package org.cyclop.service.completion.parser.insert;

import com.google.common.collect.ImmutableSortedSet;
import javax.inject.Inject;
import javax.inject.Named;
import org.cyclop.model.CqlColumnName;
import org.cyclop.model.CqlCompletion;
import org.cyclop.model.CqlKeyword;
import org.cyclop.model.CqlPart;
import org.cyclop.model.CqlQuery;
import org.cyclop.model.CqlTable;
import org.cyclop.service.cassandra.QueryService;
import org.cyclop.service.completion.parser.CompletionHelper;
import org.cyclop.service.completion.parser.MarkerBasedCompletion;

import static org.cyclop.common.QueryHelper.extractTableName;

/**
 * @author Maciej Miklas
 */
@Named("insert.ColumnsCompletion")
public class ColumnsCompletion extends MarkerBasedCompletion {

    @Inject
    private CompletionHelper completionHelper;

    @Inject
    private QueryService queryService;

    public ColumnsCompletion() {
        super(new CqlPart("("));
    }

    @Override
    public CqlCompletion getCompletion(CqlQuery query) {

        CqlTable table = extractTableName(CqlKeyword.Def.INSERT_INTO.value, query);
        ImmutableSortedSet<CqlColumnName> columnNames = queryService.findColumnNames(table);

        CqlCompletion cmp = CqlCompletion.Builder.naturalOrder().full(completionHelper.prependToCqlColumnName
                (columnNames, "(")).full(completionHelper.prependToCqlColumnName(columnNames, "," +
                "")).full(columnNames).min(columnNames).build();
        return cmp;
    }

}
