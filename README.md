# pokemon_translation_api
ポケモン外国語名の翻訳APIです。

## 開発
### ビルド環境
VSCodeの[Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)の使用を推奨。

### 構成
* web
  * アプリケーションサーバーのコンテナです。
  * Java 17
  * 8091番ポートをフォワーディングしています。
* db
  * データベースサーバーのコンテナです。
  * MySQL 5.7
* phpmyadmin
  * データベースクライアントのコンテナです。
  * データベース閲覧用。
  * 8090番ポートをフォワーディングしています。
