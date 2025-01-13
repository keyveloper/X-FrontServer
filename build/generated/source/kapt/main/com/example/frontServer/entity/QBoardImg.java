package com.example.frontServer.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardImg is a Querydsl query type for BoardImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardImg extends EntityPathBase<BoardImg> {

    private static final long serialVersionUID = 871568693L;

    public static final QBoardImg boardImg = new QBoardImg("boardImg");

    public final StringPath filename = createString("filename");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath token = createString("token");

    public final StringPath url = createString("url");

    public QBoardImg(String variable) {
        super(BoardImg.class, forVariable(variable));
    }

    public QBoardImg(Path<BoardImg> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardImg(PathMetadata metadata) {
        super(BoardImg.class, metadata);
    }

}

