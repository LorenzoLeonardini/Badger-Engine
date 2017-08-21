#pragma once

#include <string>
#include <FreeImage.h>
#include <FreeImage/Utilities.h>

namespace badger {

	/**
		Load image for FreeImage

		@param filename the file path
		@param width will be override with the width of the image
		@param height will be override with the height of the image
		@return BYTE object
	*/
	static BYTE *load_image(const char *filename, GLsizei *width, GLsizei *height)
	{
		FREE_IMAGE_FORMAT fif = FIF_UNKNOWN;
		FIBITMAP *dib = nullptr;

		fif = FreeImage_GetFileType(filename, 0);
		if (fif == FIF_UNKNOWN)
			fif = FreeImage_GetFIFFromFilename(filename);
		if (fif == FIF_UNKNOWN)
			return nullptr;

		if (FreeImage_FIFSupportsReading(fif))
			dib = FreeImage_Load(fif, filename);
		if (!dib)
			return nullptr;

		BYTE *pixels = FreeImage_GetBits(dib);

		*width = FreeImage_GetWidth(dib);
		*height = FreeImage_GetHeight(dib);
		int bits = FreeImage_GetBPP(dib);

#ifdef BADGER_EMSCRIPTEN
		SwapRedBlue32(dib);
#endif

		int size = *width * *height * (bits / 8);

		BYTE *result = new BYTE[size];
		memcpy(result, pixels, size);
		FreeImage_Unload(dib);

		return result;
	}

}