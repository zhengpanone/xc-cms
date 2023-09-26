package com.zp.manage_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * GridFsTest
 *
 * @author zhengpanone
 * @since 2022-03-14
 */
@SpringBootTest
public class GridFsTest {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;

    // @Test
    public void testGridFsStoreTest() throws FileNotFoundException {
        File file = new File("C:\\Users\\zheng\\Desktop\\Spring Security 实战干货.pdf");
        FileInputStream inputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(inputStream, "spring security.pdf");
        System.out.println(objectId);
    }

    @Test
    public void testGridFsTest() throws IOException {
        String fileId = "622f1d19e9ef46161009647e";
        GridFSFile gridfsFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        // 打开一个下载流
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridfsFile.getObjectId());
        // 创建一个GridFsResource对象
        GridFsResource gridFsResource = new GridFsResource(gridfsFile, gridFSDownloadStream);
        // 从流中取数据
        String content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        System.out.println(content);
    }

    @Test
    public void testDeleteGridFs() {
        // 根据文件ID删除fs.files和fs.chunks中的记录
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is("622f1d19e9ef46161009647e")));
    }
}
