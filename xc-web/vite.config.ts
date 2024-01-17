import { fileURLToPath, URL } from 'node:url'
// import {resolve} from 'path'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'
import visualizer from 'rollup-plugin-visualizer'
import importElementPlus from  'vite-plugin-element-plus'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import IconsResolver from 'unplugin-icons/resolver'
import Icons from 'unplugin-icons/vite'
// import { createSvgIconsPlugin } from 'vite-plugin-svg-icons' // 配置svg

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vueJsx(),
    visualizer(),
    importElementPlus({}),
/*     createSvgIconsPlugin({
      // 指定需要缓存的图标文件夹
      iconDirs:[resolve(process.cwd(),'src/asserts/icons/svg')],
      // 指定symbolId格式
      symbolId:'icon-[dir]-[name]'
    }), */
    AutoImport({
      resolvers: [
        // 自动导入 Element Plus 组件
        ElementPlusResolver(),
        
      // 自动导入图标组件
        IconsResolver({
          prefix: 'Icon',
        })],
    }),
    Components({
      resolvers: [
        // 自动导入 Element Plus 组件
        ElementPlusResolver(),
        // 自动注册图标组件
        IconsResolver({
          enabledCollections: ['ep'],
        })
    ],
    }),
    Icons({
      autoInstall: true,
    }),
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
