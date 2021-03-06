package com.squadro.touricity.database.query.routeQueries;

import com.squadro.touricity.database.ByteArrays;
import com.squadro.touricity.database.query.UpdateQuery;
import com.squadro.touricity.database.result.QueryResult;
import com.squadro.touricity.message.types.data.IPath;
import com.squadro.touricity.message.types.data.Path;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

public class UpdatePathQuery extends UpdateQuery {

    private final AtomicReference<Path> path = new AtomicReference<>();

    public UpdatePathQuery(Path path) {
        this.path.set(path);
    }

    @Override
    public String getQuery() {
        return "UPDATE db_path SET path_id = '" + path.get().getPath_id() + "', path_type = " + path.get().getPath_type() + ", vertices = '"
                + ByteArrays.Encoders.encodePathVertexArray(path.get().getVertices()) + "' WHERE path_id = '" + path.get().getPath_id() + "'";
    }

    @Override
    public boolean onResult(QueryResult result) throws SQLException {
        return false;
    }
}
