import Home from '@/module/home/page/home.vue'
import PageList from '@/module/cms/page/page_list.vue'
import PagAdd from '@/module/cms/page/page_add.vue'
import PagEdit from '@/module/cms/page/page_edit.vue'
export default [{
    path: '/',
    component: Home,
    name:"CMS", // 菜单名称
    hidden: false,
    children: [
        {
            path: 'cms/page/list',
            name: '页面列表',
            component: PageList,
            hidden: false
        },
        {
            path: 'cms/page/add',
            name: '添加页面',
            component: PagAdd,
            hidden: true
        },
        {
            path: 'cms/page/edit/:pageId',
            name: '修改页面',
            component: PagEdit,
            hidden: true
        }
    ]
}]