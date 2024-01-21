import Home from '@/module/home/page/home.vue'
import PageList from '@/module/cms/page/page-list.vue';
export default [{
    path: '/',
    component: Home,
    name: 'CMS',
    hidden: false,
    children:[{
        path: '/cms/page/list',
        component: PageList,
        name: '页面列表',
        hidden: false
    }

    ]
}
]
