<template>
  <div>
    <el-form :model="pageForm" :rules="pageFormRules" ref="pageFormRef" label-width="80px">

      <el-form-item label="所属站点" prop="siteId">
        <el-select v-model="pageForm.siteId" placeholder="请选择站点">
          <el-option v-for="item in siteList" :key="item.siteId" :label="item.siteName"
                     :value="item.siteId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="选择模版" prop="templateId">
        <el-select v-model="pageForm.templateId" placeholder="请选择模版">
          <el-option v-for="item in templateList" :key="item.templateId" :label="item.templateName"
                     :value="item.templateId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="页面名称" prop="pageName">
        <el-input v-model="pageForm.pageName" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="页面别名" prop="pageAliase">
        <el-input v-model="pageForm.pageAliase" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="访问路径" prop="pageWebPath">
        <el-input v-model="pageForm.pageWebPath" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="物理路径" prop="pagePhysicalPath">
        <el-input v-model="pageForm.pagePhysicalPath" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="数据Url" prop="dataUrl">
        <el-input v-model="pageForm.dataUrl" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="页面类型">
        <el-radio-group v-model="pageForm.pageType">
          <el-radio class="radio" :label="0">静态</el-radio>
          <el-radio class="radio" :label="1">动态</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker type="datetime" placeholder="创建时间" v-model="pageForm.pageCreateTime"></el-date-picker>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="addSubmit" :loading="addLoading">提交</el-button>
      <el-button type="primary" @click="goBack">返回</el-button>
    </div>
  </div>
</template>
<script>
import * as cmsApi from '../api/cms'

export default {
  created() {
    // 初始化站点列表
    cmsApi.site_list(1, 10).then(res => {
      this.siteList = res.data.list
    });
    // 初始化模版列表
    cmsApi.template_list(1, 10,).then(res => {
      this.templateList = res.data.list
    })
  },
  data() {
    return {
      pageForm: {
        siteId: '',
        templateId: '',
        pageName: '',
        pageAliase: '',
        pageWebPath: '',
        pagePhysicalPath: '',
        dataUrl:'',
        pageType: '',
        pageCreateTime: new Date()
      },
      addLoading: false,
      siteList: [],
      templateList: [],
      pageFormRules: {
        siteId: [{required: true, message: '请选择站点', trigger: 'blur'}],
        templateId: [{required: true, message: '请选择模版', trigger: 'blur'}],
        pageName: [{required: true, message: '请输入页面名称', trigger: 'blur'}],
        pageWebPath: [{required: true, message: '请输入访问路径', trigger: 'blur'}],
        pagePhysicalPath: [{required: true, message: '请输入物理路径', trigger: 'blur'}],
      }
    }

  },
  methods: {
    addSubmit() {
      this.$refs['pageFormRef'].validate((valid) => {
        if (valid) { // 表达校验成功
          // 确认提示
          this.$confirm('确认是否新增页面', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消'
          }).then(() => {
            this.addLoading = true
            cmsApi.page_add(this.pageForm).then(res => {
              this.addLoading=false
              if (res.code === 200) {
                this.$message({
                  message: '新增页面成功',
                  type: 'success'
                })
                this.$refs['pageFormRef'].resetFields()
              } else {
                this.addLoading=false
                this.$message.error('新增页面失败')
              }
            })
          }).catch(() => {
            this.$message.info('取消新增')
          })

        }
      })
    },
    goBack() {
      this.$router.push({
        path: '/cms/page/list',
        query: {
          page: this.$route.query.page,
          size: this.$route.query.size,
          siteId: this.$route.query.siteId
        }
      })
    }
  }
}

</script>

<style></style>