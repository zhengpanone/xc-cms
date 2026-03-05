<template>
    <div>
        <el-form :inline="true" :model="params" class="demo-form-inline">
            <el-form-item label="站点">
                <el-select v-model="params.siteId" placeholder="请选择站点" size="small">
                    <el-option v-for="item in siteList" :key="item.siteId" :label="item.siteName" :value="item.siteId">
                    </el-option>

                </el-select>
            </el-form-item>
            <el-form-item label="页面别名">
                <el-input v-model="params.pageAliase" placeholder="请输入页面别名" size="small"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" size="small" @click="query">查询</el-button>
            </el-form-item>
            <el-form-item>
                <router-link :to="{ path: '/cms/page/add', query: { page: this.page, siteId: this.params.siteId } }">
                    <el-button type="primary" size="small" @click="query">添加页面</el-button>
                </router-link>
            </el-form-item>
        </el-form>

        <el-table :data="tableData" stripe style="width: 100%" :fit=true>
            <el-table-column prop="pageName" label="页面名称">
            </el-table-column>
            <el-table-column prop="pageAliase" label="别名">
            </el-table-column>
            <el-table-column prop="pageType" label="页面类型">
            </el-table-column>
            <el-table-column prop="pageWebPath" label="访问路径">
            </el-table-column>
            <el-table-column prop="pagePhysicalPath" label="物理路径">
            </el-table-column>
            <el-table-column prop="pageCreateTime" label="创建时间">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click="handleEdit(scope.row.pageId)">编辑</el-button>
                    <el-button @click="handleDelete(scope.row.pageId)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="total, sizes, prev, pager, next, jumper" :total="total" :page-size=size
            :page-sizes="[10, 20, 30, 50]" :current-page=page @current-change="changePage" style="float:right">
        </el-pagination>
    </div>
</template>

<script>
import { pageList, siteList, pageDelete } from '../api/cms'
export default {
    data() {
        return {
            tableData: [],
            siteList: [],
            total: 0,
            page: 1,
            size: 10,
            params: {
                siteId: '',
                pageAliase: '',

            }

        }
    },
    methods: {
        query: function () {
            pageList(this.page, this.size, this.params).then((res) => {
                this.tableData = res.queryResult.list
                this.total = res.queryResult.total
            })
        },
        changePage: function (currentPage) {
            this.page = currentPage
            this.query()
        },
        handleEdit: function (pageId) {
            this.$router.push({
                path: `/cms/page/edit/${pageId}`
            })

        },
        handleDelete: function (pageId) {
            pageDelete(pageId).then((res) => {
                if (res.success) {
                    this.$message.success('删除成功')
                    this.query()
                } else {
                    this.$message.error('删除失败')
                }

            })
        }

    },
    created() {
        console.log(this.$route)
        this.page = Number.parseInt(this.$route.query.page || 1)
        this.params.siteId = this.$route.query.siteId || ''
    },
    mounted() { // DOM元素渲染后
        this.query()
        siteList().then((res) => {
            this.siteList = res.queryResult.list
        })
    }
}
</script>