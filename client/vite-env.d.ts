interface ViteTypeOptions {
  // By adding this line, you can make the type of ImportMetaEnv strict
  // to disallow unknown keys.
  // strictImportMetaEnv: unknown
}

interface ImportMetaEnv {
  readonly VITE_APP_TITLE: string;
  // more env variables...
  readonly API_URL: string;
}

interface ImportMeta {
  readonly env: ImportMetaEnv;
}
