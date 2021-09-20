package buttons.app

import android.media.AudioManager
import android.service.quicksettings.TileService
import androidx.appcompat.app.AppCompatActivity

class VolumeTileService:TileService()
{
    override fun onClick()
    {
        super.onClick()
        val audioManager=applicationContext.getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
        audioManager.adjustVolume(AudioManager.ADJUST_SAME,AudioManager.FLAG_SHOW_UI)
    }
}