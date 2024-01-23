import Home from '@/module/home/page/home.vue'
import PageList from '@/module/cms/page/page-list.vue'
import PageAdd from '@/module/cms/page/page-add.vue'
import PageEdit from '@/module/cms/page/page-edit.vue'


export default [{
    path: '/',
    component: Home,
    name: 'CMS',
    hidden: false,
    children: [{
        path: '/cms/page/list',
        component: PageList,
        name: '页面列表',
        hidden: false
    }, {
        path: '/cms/page/add',
        component: PageAdd,
        name: '新增页面',
        hidden: true
    }, {
        path: '/cms/page/edit/:pageId',
        component: PageEdit,
        name: '修改页面',
        hidden: true
    }

    ]
}
]
