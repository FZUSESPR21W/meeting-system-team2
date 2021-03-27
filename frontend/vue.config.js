var path = require("path");

const resolve = url =>
{
    return path.join(__dirname, url);
};

module.exports = {
    runtimeCompiler: true,

    css: {
        loaderOptions: {
            scss: {
                prependData: `@import "@/style/global.scss";`
            }
        }
    },

    configureWebpack: {
        resolve: {
            alias: {
                "@": resolve("./src")
            },
            extensions: ["*", ".js", ".vue", ".json"]
        }
    },

    //代理 防跨域问题
    // devServer: {
    //     proxy: {
    //         '/api': {
    //             target: "",
    //             changeOrigin: true,
    //             pathRewrite: {
    //                 '^/api': ''
    //             }
    //         }
    //     }
    // },

    lintOnSave: false
};