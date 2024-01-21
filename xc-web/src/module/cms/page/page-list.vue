<template>
  <div>
    <el-button type="primary" @click="handleQuery">查询</el-button>
    <el-table
        :data="cmsPageList"
        border
        style="width: 100%">
      <el-table-column fixed type="index" width="60"></el-table-column>
      <el-table-column prop="pageName" label="页面名称" width="150"></el-table-column>
      <el-table-column prop="pageAliase" label="别名" width="120"></el-table-column>
      <el-table-column prop="pageType" label="页面类型" width="150"></el-table-column>
      <el-table-column prop="pageWebPath" label="访问路径" width="250"></el-table-column>
      <el-table-column prop="pagePhysicalPath" label="物理路径" width="300"></el-table-column>
      <el-table-column prop="pageCreateTime" label="创建时间" width="180"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        style="float:right"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="params.page"
        :page-sizes="[10, 20, 30, 50]"
        :page-size="params.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
</template>


<script>
import * as cmsApi from '../api/cms'

export default {
  mounted() {
    this.handleQuery()
  },
  methods: {
    handleQuery() {
      cmsApi.page_list(this.params.page,this.params.size,{}).then((res)=>{
        console.log(res)
        this.cmsPageList = res.data.list
        this.total = res.data.total
      })
    },
    handleCurrentChange: function (page) { // 当前页码
      this.params.page = page
      this.handleQuery()
    },
    handleSizeChange: function () {

    }
  },

  data() {
    return {
      cmsPageList: [],
      total: 0,
      params: {
        page: 1,
        size: 10
      }
    }
  },
}
</script>


<style>

</style>