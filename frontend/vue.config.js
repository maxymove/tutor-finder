module.exports = {
  "devServer": {
    "proxy": {
      "/api": {
        "target": "http://localhost:9090",
        "ws": true,
        "changeOrigin": true
      }
    }
  },
  "outputDir": "target/dist",
  "assetsDir": "static",
  "transpileDependencies": [
    "vuetify"
  ]
}