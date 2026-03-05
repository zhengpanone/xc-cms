<template>
  <div>
    <el-form :model="params" :inline="true">
      <el-select v-model="params.siteId" clearable placeholder="请选择站点">
        <el-option
            v-for="item in siteList"
            :key="item.siteId"
            :label="item.siteName"
            :value="item.siteId">
        </el-option>
      </el-select>

      <el-form-item label="页面别名">
        <el-input v-model="params.pageAliase" placeholder="页面别名"></el-input>
      </el-form-item>
      <el-button type="primary" @click="handleQuery">查询</el-button>
      <router-link :to="{path: '/cms/page/add',query:{
        page: this.params.page,
        size: this.params.size,
        siteId: this.params.siteId
      }}">
        <el-button type="primary">新增页面</el-button>
      </router-link>
    </el-form>
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
        <template slot-scope="page">
          <el-button type="text" size="small" @click="edit(page.row.pageId)">编辑</el-button>
          <el-button type="text" size="small" @click="deletePage(page.row.pageId)">删除</el-button>
          <el-button type="text" size="small" @click="preview(page.row.pageId)">页面预览</el-button>
          <el-button type="text" size="small" @click="publishPage(page.row.pageId)">页面发布</el-button>
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
import {page_edit} from "../api/cms";

export default {
  mounted() {
    this.handleQuerySiteList()
    this.handleQuery()
  },
  created() {
    this.params.page = Number.parseInt(this.$route.query.page || 1)
    this.params.size = Number.parseInt(this.$route.query.size || 10)
    this.params.siteId = this.$route.query.siteId || ''
  },
  methods: {
    handleQuery() {
      cmsApi.page_list(this.params.page, this.params.size, this.params).then((res) => {
        this.cmsPageList = res.data.list
        this.total = res.data.total
      })
    },
    handleCurrentChange: function (page) { // 当前页码
      this.params.page = page
      this.handleQuery()
    },
    handleSizeChange: function () {

    },
    handleQuerySiteList() {
      cmsApi.site_list(1, 10, {}).then(res => {
        this.siteList = res.data.list
      })
    },
    edit(pageId) {
      this.$router.push(
          {
            path: '/cms/page/edit/' + pageId,
            query: {page: this.params.page, siteId: this.params.siteId}
          }
      )
    },
    deletePage(pageId) {
      this.$confirm('确认是否删除页面', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(() => {
        cmsApi.page_delete(pageId).then(res => {
          if (res.code === 200) {
            this.$message.success("删除成功")
            this.handleQuery()
          } else {
            this.$message.error('删除失败')
          }
        })
      })

    },
    preview(pageId){
      window.open("http://localhost/cms/preview/"+pageId)
    },
    publishPage(pageId){
      this.$confirm('确认是否发布页面','提示',{
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(()=>{
        cmsApi.page_publishPage(pageId).then(res=>{
          if(res.code === 200){
            this.$message.success('页面发布成功，请稍后查看结果')
          }else{
            this.$message.error('页面发布失败')
          }
        })
      }).catch(()=>{
        
      })
    }
  },

  data() {
    return {
      cmsPageList: [],
      siteList: [],
      total: 0,
      params: {
        page: 1,
        size: 10,
        siteId: '',
        pageAliase: ''
      }
    }
  },
}
</script>


<style>

</style>