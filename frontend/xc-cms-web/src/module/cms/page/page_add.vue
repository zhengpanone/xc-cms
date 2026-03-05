<template>
    <div>
        <el-form ref="formRef" :model="pageForm" :rules="pageFormRule" label-width="80px">
            <el-form-item label="所属站点" prop="siteId">
                <el-select v-model="pageForm.siteId" placeholder="请选择站点" style="width:100%">
                    <el-option v-for="item in siteList" :key="item.siteId" :label="item.siteName" :value="item.siteId">
                    </el-option>
                </el-select>

            </el-form-item>
            <el-form-item label="模板" prop="templateId">
                <el-select v-model="pageForm.templateId" placeholder="选择模板" style="width:100%">
                    <el-option v-for="item in templateList" :key="item.templateId" :label="item.templateName"
                        :value="item.templateId">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="页面名称" prop="pageName">
                <el-input v-model="pageForm.pageName"></el-input>
            </el-form-item>
            <el-form-item label="页面别名" prop="pageAliase">
                <el-input v-model="pageForm.pageAliase"></el-input>
            </el-form-item>

            <el-form-item label="访问路径" prop="pageWebPath">
                <el-input v-model="pageForm.pageWebPath"></el-input>
            </el-form-item>
            <el-form-item label="物理路径" prop="pagePhysicalPath">
                <el-input v-model="pageForm.pagePhysicalPath"></el-input>
            </el-form-item>


            <el-form-item label="类型">
                <el-radio-group v-model="pageForm.pageType">
                    <el-radio label="0">静态</el-radio>
                    <el-radio label="1">动态</el-radio>
                </el-radio-group>
            </el-form-item>
            <!-- <el-form-item label="创建时间">
                <el-col :span="24">
                    <el-form-item>
                        <el-date-picker type="date" placeholder="选择日期" v-model="pageForm.pageCreateTime"
                            style="width: 100%;">
                        </el-date-picker>

                    </el-form-item>
                </el-col>
            </el-form-item> -->
            <el-form-item>
                <el-button type="primary" @click="onSubmit('formRef')" :loading="submitLoading">提交</el-button>
                <el-button @click="goBack">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import { siteList as siteListApi, templateList as templateListApi, pageAdd } from '../api/cms'
export default {
    data() {
        return {
            submitLoading: false,
            //模版列表
            templateList: [],
            //站点列表
            siteList: [],
            //新增界面数据
            pageForm: {
                siteId: '',
                templateId: '',
                pageName: '',
                pageAliase: '',
                pageWebPath: '',
                pagePhysicalPath: '',
                pageType: '',
                pageCreateTime: new Date()

            },

            pageFormRule: {
                siteId: [
                    { required: true, message: '请选择所属站点', trigger: 'blur' }
                ],
                templateId: [
                    { required: true, message: '请选择所模板', trigger: 'change' }
                ],
                pageName: [
                    { required: true, message: '请输入页面名称', trigger: 'blur' }
                ],
                pageWebPath: [{ required: true, message: '请输入访问路径', trigger: 'blur' }],
                pagePhysicalPath: [{ required: true, message: '请输入物理路径', trigger: 'blur' }]
            }
        }
    },
    mounted() {
        siteListApi().then((res) => {
            this.siteList = res.queryResult.list
        })
        templateListApi().then((res) => {
            this.templateList = res.queryResult.list
        })
    },
    methods: {
        onSubmit(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$confirm('确认是否提交?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.submitLoading = true
                        pageAdd(this.pageForm).then(res => {
                            if (res.success) {
                                this.$message.success('添加成功')
                                this.$refs[formName].resetFields()
                            } else {
                                this.$message.error('提交失败')
                            }
                        }).finally(() => {
                            this.submitLoading = false
                        })
                    })
                } else {
                    console.log('error submit');
                    return false
                }

            })
        },
        goBack() {
            this.$router.push({
                path: '/cms/page/list',
                query: {
                    page: this.$route.query.page,
                    siteId: this.$route.query.siteId
                }
            })
        }
    }
}
</script>