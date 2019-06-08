interface ComposeOptions {
  text?: string
  image?: string
  url?: string
}

export interface RNTwitterKit {
  compose: (options: ComposeOptions) => Promise<boolean>
}